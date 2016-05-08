$deploy = <<SCRIPT

apt-get update
apt-get install python-pip python-dev git -y
pip install ansible


SCRIPT

VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  config.vm.box = "debian/jessie64"

  config.vm.provider "virtualbox" do |v|
    v.memory = 2048
    v.cpus = 2
  end

  config.vm.network "private_network", type: "dhcp", ip: "192.168.40.3"

  config.vm.provider "virtualbox"

  if(Vagrant::Util::Platform.windows?)
    local_folder = "/vagrant"

    config.winnfsd.uid = Process.uid
    config.winnfsd.gid = Process.gid
  else
    local_folder = File.dirname(__FILE__)
    config.nfs.map_uid = Process.uid
    config.nfs.map_gid = Process.gid
  end

  config.vm.synced_folder ".", local_folder, type: "nfs"

  config.vm.provision "shell", inline: $deploy
end
